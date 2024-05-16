function triggerFileInput() {
    document.getElementById('file').click();
}

var loadFile = function(event) {
    var file = event.target.files[0];
    var image = document.getElementById("fotoperfil");

    // Validar el tipo de archivo
    var validTypes = ["image/png", "image/jpeg"];
    if (!validTypes.includes(file.type)) {
        alert("Por favor, selecciona un archivo PNG o JPEG.");
        // Reiniciar el input file
        event.target.value = "";
        return;
    }

    image.src = URL.createObjectURL(file);
}
