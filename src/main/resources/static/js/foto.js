function triggerFileInput() {
    document.getElementById('file').click();
}


var loadFile = function(event) {
    var image = document.getElementById("fotoperfil");
    image.src = URL.createObjectURL(event.target.files[0]);
}