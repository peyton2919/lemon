<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>图片上传</title>
    <link rel="stylesheet" href="/demo/mult_upload/css/tinyImgUpload.css">
</head>
<body>

<div id="upload">

</div>
<button class="submit">submit</button>
<script src="/js/jquery-1.9.1.min.js"></script>
<script src="/demo/mult_upload/js/tinyImgUpload.js"></script>
<script>
document.documentElement.style.fontSize = document.documentElement.clientWidth*0.1+'px';

var options = {
    path: '/upload.json',
    onSuccess: function (res) {
        console.log(res);
    },
    onFailure: function (res) {
        console.log(res);
    }
}

var upload = tinyImgUpload('#upload', options);
var upload1 = new upload('',options);

document.getElementsByClassName('submit')[0].onclick = function (e) {
    upload();
}
</script>
</body>
</html>