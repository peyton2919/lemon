
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>图片上传</title>
    <link rel="stylesheet" href="/css/upload-mult.css">
</head>
<body>

<div id="upload">

</div>
<form id="testForm" method="POST" name="testForm">
	<input type="text" value ="50" name = "id">
	<input type="text" value ="peyton" name = "name">
	<input type="text" value ="说明" name = "explain">
    <button class="submit">submit</button>
</form>

<script src="/js/defined/upload-mult.js"></script>

<script>
// document.documentElement.style.fontSize = document.documentElement.clientWidth * 0.05+'px';

var options = {
    url: '/upload.json',
	formId: 'testForm',
    onSuccess: function (res) {
        console.log(res);
        alert(res);
    },
    onFailure: function (res) {
        console.log(res);
    },
	onMessage : function (res){
		alert(res);
	}
}

var upload = uploadMultipart('#upload', options);
document.getElementsByClassName('submit')[0].onclick = function (e) {
	options.name = "重新加载数据!";
    upload();
}
</script>
</body>
</html>