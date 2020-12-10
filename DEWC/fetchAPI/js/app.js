window.onload=function(){
    document.getElementById('aceptar').addEventListener('click', function() {
        fetch('ejemplo.txt')
          .then(ajaxPositive)
          .catch(showError);
      });
}

    function ajaxPositive(response) {
      console.log('response.ok: ', response.ok);
      if(response.ok) {
        response.text().then(showResult);
      } else {
        showError('status code: ' + response.status);
      }
    }

    function showResult(txt) {
      console.log('muestro respuesta: ', txt);
    }

    function showError(err) { 
      console.log('muestor error', err);
    }
  