const boardUpdate = () => {
    const pass = document.getElementById("board-pass").value;
    const inputPass = document.getElementById("boardPass").value;
    console.log("pass: ", pass);
    console.log("inputPass: ", inputPass);
    if (pass == inputPass) {
        document.updateForm.submit();
    } else {
        alert("비밀번호가 일치하지 않습니다!");
    }
}