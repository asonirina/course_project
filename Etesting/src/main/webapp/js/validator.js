function checkAll() {
    var valid = false;
    var x;
    var check_zeroLength = document.getElementById('check_zeroLength').value;
    if (check_zeroLength == 1) {
        valid = true;
    } else {
        valid = false;
        alert("Заполните все обязательные поля!");
    }
    return valid;
}

function checkZeroLength(item, id) {
    if (document.getElementById(item).value.length == 0) {
        document.getElementById(id).innerHTML = 'поле не должно быть пустым';
        document.getElementById(id).className = 'acorrect';
        document.getElementById('check_zeroLength').value = 0;
    } else if (document.getElementById("firstName").value.length == 0 || document.getElementById("secondName").value.length == 0 ||
        document.getElementById("form").value.length == 0 || document.getElementById("login").value.length == 0 ||
        document.getElementById("password").value.length == 0) {
        document.getElementById(id).innerHTML = 'верно';
        document.getElementById(id).className = 'correct';
        document.getElementById('check_zeroLength').value = 0;
    } else {
        document.getElementById(id).innerHTML = 'верно';
        document.getElementById(id).className = 'correct';
        document.getElementById('check_zeroLength').value = 1;
    }
}