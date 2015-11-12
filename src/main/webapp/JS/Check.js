function checkForm() {
    var email = document.regForm.enail.value;
    var reg = /^((\w+(\-|\.)?)+)@((\w{2,}\.)+\w{2,6})$/;

    if (!reg.test(email)) {
        alert("Invalid Email");
        return false;
    }

    var password = document.regForm.password.value;

    if (password.length < 6) {
        alert("Password is too short");
         return false;
    }

    document.getElementById("symbol").innerHTML = s.length;
    var radio = document.getElementsByName("gender");

    if (!radio[0].checked && !radio[1].checked) {
        alert("Choose gender");
        return false;
    }
    return true;
}

function count (str) {
    document.getElementById('symbols').innerHTML=str.length;
}