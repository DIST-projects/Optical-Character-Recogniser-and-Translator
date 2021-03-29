<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Optimal Character Recognizer</title>
<style>
h1 {
text-align: center;
}
p {
text-align: center;
}
form { 
margin: 0 auto; 
width:250px;
}
.image-preview {
	width: 300px;
	min-height: 100px;
	border: 2px solid #dddddd;
	margin-top: 15px;
	display: flex;
	align-items: center;
	justify-content: center;
	font-weight: bold;
	color: #cccccc;
}

.image-preview__image {
	display: none;
	width: 100%;
}
</style>
</head>
<body bgcolor="lightblue">
	<br>
	<br>
	<h1>Optimal Character Recognizer</h1>
	<p>Upload a file </p>
	<br>
	<br>
	<form action="uploadFile" method="post" enctype="multipart/form-data">
		<input type="file" name="uploadFile" id="uploadFile">
		<div class="image-preview" id="imagepreview">
			<img src="" alt="Image Preview" class="image-preview__image"> <span
				class="image-preview__default-text"> Image Preview </span>
		</div>
		<br>
		<br> <input type="submit" value="Upload">
	</form>
	<script>
		const inpFile = document.getElementById("uploadFile");
		const previewContainer = document.getElementById("imagepreview");
		const previewImage = previewContainer
				.querySelector(".image-preview__image");
		const previewDefaultText = previewContainer
				.querySelector(".image-preview__default-text");
		inpFile.addEventListener("change", function() {
			const file = this.files[0];
			//console.log(file);
			if (file) {
				const reader = new FileReader();
				previewDefaultText.style.display="none";
				previewImage.style.display = "block";
				reader.addEventListener("load", function() {
					console.log(this);
					previewImage.setAttribute("src", this.result);
				});
				reader.readAsDataURL(file);
			} else {
				previewDefaultText.style.display=null;
				previewImage.style.display = null;
				previewImage.setAttribute("src", "");
			}
		});
	</script>
</body>
</html>
