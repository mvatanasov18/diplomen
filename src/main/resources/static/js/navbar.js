function getCookie(cname) {
    let name = cname + "=";
    let decodedCookie = decodeURIComponent(document.cookie);
    let ca = decodedCookie.split(';');
    for(let i = 0; i <ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0) === ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) === 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function setLinks(){
    const navbar = document.getElementById("place");
    const cookie = getCookie("session");
    if(cookie===""){
        navbar.innerHTML+="<li class=\"nav-item\">\n" +
            "                    <a class=\"nav-link active\" aria-current=\"page\" href=\"/\">Home</a>\n" +
            "                </li>\n" +
            "                <li class=\"nav-item\">\n" +
            "                    <a class=\"nav-link\" href=\"/register\">Register</a>\n" +
            "                </li>\n" +
            "                <li class=\"nav-item\">\n" +
            "                    <a class=\"nav-link\" href=\"/login\">Login</a>\n" +
            "                </li>"
    }else{
        navbar.innerHTML+="<li class=\"nav-item\">\n" +
            "                    <a class=\"nav-link active\" aria-current=\"page\" href=\"/home\">Home</a>\n" +
            "                </li>\n" +
            "                <li class=\"nav-item\">\n" +
            "                    <a class=\"nav-link\" href=\"/students\">Manage Students </a>\n" +
            "                </li>\n" +
            "                <li class=\"nav-item\">\n" +
            "                    <a class=\"nav-link\" href=\"/teachers\">Manage Teachers</a>\n" +
            "                </li>" +
            "                 <li class=\"nav-item\">" +
            "                  <a class=\"nav-link\" href=\"/profile\">Profile</a></li>"

    }
}

function insertNavbar(){
    const body = document.getElementById("body");
    body.innerHTML="<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\n" +
        "    <div class=\"container-fluid\">\n" +
        "        <a class=\"navbar-brand\" href=\"/\">SaT</a>\n" +
        "        <button aria-controls=\"navbarText\" aria-expanded=\"false\" aria-label=\"Toggle navigation\" class=\"navbar-toggler\"\n" +
        "                data-bs-target=\"#navbarText\" data-bs-toggle=\"collapse\" type=\"button\">\n" +
        "            <span class=\"navbar-toggler-icon\"></span>\n" +
        "        </button>\n" +
        "        <div class=\"collapse navbar-collapse\" id=\"navbarText\">\n" +
        "            <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\" id=\"place\">\n" +
        "\n" +
        "            </ul>\n" +
        "        </div>\n" +
        "    </div>\n" +
        "</nav>" +body.innerHTML;
}


    insertNavbar();
    setLinks();


