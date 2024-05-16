document.getElementById('pdfInput').addEventListener('change', function(event) {
    var file = event.target.files[0];
    var pdfViewer = document.getElementById('pdfViewer');

    if (file) {
        var reader = new FileReader();
        reader.onload = function(event) {
            pdfViewer.src = event.target.result;
            pdfViewer.hidden = false;
        };
        reader.readAsDataURL(file);
    }
});
