const idCheck = () => {
    const id = document.getElementById("id").value;
    const checkResult = document.getElementById("checkResult");
    console.log("입력값 :", id);
    $.ajax({
        type: "post",
        url: "/capoeiraweb/member/idCheck",
        data: {
            "id": id
        },
        success: function(res) {
            console.log("요청성공", res);
            if (res == "ok") {
                checkResult.style.color = "green";
                checkResult.innerHTML = "사용가능한 아이디 입니다.";
            } else {
                checkResult.style.color = "red";
                checkResult.innerHTML = "이미 사용중인 아이디 입니다.";
            }
        },
        error: function(err) {
            console.log("에러발생", err);
        }
    });
}
const pwCheck = () => {
  const password = document.getElementById("password").value;
  const confirmPassword = document.getElementById("password-confirm").value;


 if (password === confirmPassword) {
     passwordCheckResult.style.color = "green";
     passwordCheckResult.innerHTML = "비밀번호가 일치합니다.";
   } else {
     passwordCheckResult.style.color = "red";
     passwordCheckResult.innerHTML = "비밀번호가 일치하지 않습니다.";
  }
}
