function previewAvatar(event) {
    let reader = new FileReader();
    reader.onload = function() {
        let output = document.getElementById('avatar-preview');
        output.src = reader.result;
        output.hidden = false; // Show the image
        document.querySelector('.avatar-uploader-icon').style.display = 'none';
    };
    reader.readAsDataURL(event.target.files[0]);
}