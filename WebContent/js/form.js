     function carica(input) {
            if (input.files && input.files[0]) {
                var leggi = new FileReader();

                leggi.onload = function (e) {
                    $('#immagine')
                        .attr('src', e.target.result)
                        .width(200)
                        .height(200);
                };

                leggi.readAsDataURL(input.files[0]);
            }
        }