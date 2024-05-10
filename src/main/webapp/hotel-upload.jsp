<%--
  Created by IntelliJ IDEA.
  User: 刘牧天
  Date: 2024/5/10
  Time: 6:27
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="header.jsp" %>

<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <h1 class="text-center">Upload a New Hotel</h1>
                    <form action="<%= request.getContextPath() %>/hotel_uploading" method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <label for="name">Hotel Name:</label>
                            <input type="text" class="form-control" id="name" name="name" placeholder="Hotel Name">
                        </div>
                        <div class="form-group">
                            <label for="description">Description:</label>
                            <input type="text" class="form-control" id="description" name="description" placeholder="Hotel Description">
                        </div>
                        <div class="form-group">
                            <label for="city">City:</label>
                            <input type="text" class="form-control" id="city" name="city" placeholder="Enter your city">
                        </div>
                        <div class="form-group" id="fileInputs">
                            <label for="pictures">Pictures:</label>
                            <input type="file" class="form-control-file" id="pictures" name="pictures" multiple>
                        </div>
                        <div id="imagePreview"></div>
                        <button type="button" class="btn btn-primary btn-block" onclick="addFileInput()">Add Picture</button>
                        <button type="submit" class="btn btn-primary btn-block">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    var images = [];

    function addFileInput() {
        var fileInputsContainer = document.getElementById("fileInputs");
        var input = document.createElement("input");
        input.type = "file";
        input.name = "pictures";
        input.className = "form-control-file";
        input.multiple = true;
        input.addEventListener("change", previewImages);
        fileInputsContainer.appendChild(input);
    }

    function previewImages(event) {
        var preview = document.getElementById("imagePreview");
        var files = event.target.files;
        for (var i = 0; i < files.length; i++) {
            var file = files[i];
            var reader = new FileReader();
            reader.onload = function(e) {
                var img = document.createElement("img");
                img.src = e.target.result;
                img.style.maxWidth = "200px";
                img.style.maxHeight = "200px";
                img.addEventListener("click", function() {
                    this.parentNode.removeChild(this);
                });
                preview.appendChild(img);

                // Convert image to base64 and store in array
                var canvas = document.createElement("canvas");
                var ctx = canvas.getContext("2d");
                ctx.drawImage(img, 0, 0);
                var base64 = canvas.toDataURL("image/jpeg");
                images.push(base64);
            };
            reader.readAsDataURL(file);
        }
    }

    function submitForm() {
        var form = document.getElementById("hotelForm");
        var input = document.createElement("input");
        input.type = "hidden";
        input.name = "base64Images";
        input.value = JSON.stringify(images);
        form.appendChild(input);
        form.submit();
    }
</script>

<%@ include file="footer.jsp" %>