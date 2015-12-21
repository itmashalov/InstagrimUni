/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//AJAX========================================================================================================================================
function getXMLObject()  //XML OBJECT
{
    var xmlHttp = false;
    try {
        xmlHttp = new ActiveXObject("Msxml2.XMLHTTP")  // For Old Microsoft Browsers
    } catch (e) {
        try {
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP")  // For Microsoft IE 6.0+
        } catch (e2) {
            xmlHttp = false   // No Browser accepts the XMLHTTP Object then false
        }
    }
    if (!xmlHttp && typeof XMLHttpRequest != 'undefined') {
        xmlHttp = new XMLHttpRequest(); //For Mozilla, Opera Browsers
    }
    return xmlHttp; // Mandatory Statement returning the ajax object created
}

var xmlhttp = new getXMLObject(); //xmlhttp holds the ajax object
var commentsID;
function ajaxAddComment(newCommentID, imgID) {
    var getdate = new Date(); //Used to prevent caching during ajax call
    if (xmlhttp) {

        var comment = document.getElementById(newCommentID).value;

        commentsID = "comments" + newCommentID;
        xmlhttp.open("POST", "AddCommentServlet?comment=" + comment + "&imgID=" + imgID, true); //gettime will be the servlet name
        xmlhttp.onreadystatechange = handleServerResponseComments;
        xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xmlhttp.send();
    }
}

function ajaxOpenFrame(newCommentID, imgID) {

    if (oppened == 0) {
        var getdate = new Date(); //Used to prevent caching during ajax call
        if (xmlhttp) {

            var comment = "";
            commentsID = "comments" + newCommentID;
            xmlhttp.open("POST", "AddCommentServlet?comment=" + comment + "&imgID=" + imgID, true); //gettime will be the servlet name
            xmlhttp.onreadystatechange = handleServerResponseComments;
            xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xmlhttp.send();
        }
    }
    openned = 1;
}

function handleServerResponseComments() {
    if (xmlhttp.readyState == 4) {
        if (xmlhttp.status == 200) {
            document.getElementById(commentsID).innerHTML = xmlhttp.responseText; //Update the HTML Form element
        } else {
            alert("Error during AJAX call. Please try again");
        }
    }
}


function ajaxDeleteComment(imgID) {
    var getdate = new Date(); //Used to prevent caching during ajax call
    if (xmlhttp) {

        var command = "delete";
        xmlhttp.open("POST", "ImageOperationsServlet?command=" + command + "&imgID=" + imgID, true); //gettime will be the servlet name
        xmlhttp.onreadystatechange = handleServerResponseDeleteImg;
        xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xmlhttp.send();
    }
}
function handleServerResponseDeleteImg() {
    if (xmlhttp.readyState == 4) {
        if (xmlhttp.status == 200) {
            var resp = xmlhttp.responseText;
            //alert(resp);
            //document.getElementById(commentsID).innerHTML = xmlhttp.responseText; //Update the HTML Form element
        } else {
            alert("Error during AJAX call. Please try again");
        }
    }
}
//comments count
var xmlhttp2 = new getXMLObject(); //xmlhttp holds the ajax object

var commentID2 = 0;
function ajaxGetCommentsCount(imgID) {
    var getdate = new Date(); //Used to prevent caching during ajax call
    if (xmlhttp2) {

        var command = "getCommentsCount";
        commentID2 = imgID;
        xmlhttp2.open("POST", "ImageOperationsServlet?command=" + command + "&imgID=" + imgID, true); //gettime will be the servlet name
        xmlhttp2.onreadystatechange = handleServerGetCommentsCount;
        xmlhttp2.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xmlhttp2.send();
    }
}
function handleServerGetCommentsCount() {
    if (xmlhttp2.readyState == 4) {
        if (xmlhttp2.status == 200) {
            var resp = xmlhttp2.responseText;

            id2 = commentID2 * 2.21111;
            document.getElementById(id2).innerHTML = xmlhttp2.responseText;
            document.getElementById(id2).value = xmlhttp2.responseText;//Update the HTML Form element
        } else {
            alert("Error during AJAX call. Please try again");
        }
    }
}
//get gallery 
var xmlhttp3 = new getXMLObject(); //xmlhttp holds the ajax object
function ajaxGetGallery(usrID, tag) {


    var getdate = new Date(); //Used to prevent caching during ajax call
    if (xmlhttp3) {

        xmlhttp3.open("POST", "GalleryServlet?userID=" + usrID + "&tag=" + tag, true); //gettime will be the servlet name
        xmlhttp3.onreadystatechange = handleServerResponseGallery;
        xmlhttp3.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xmlhttp3.send();
        spinIconOn()
    }


}

function handleServerResponseGallery() {
    if (xmlhttp3.readyState == 4) {
        if (xmlhttp3.status == 200) {
            document.getElementById("ib-container2").innerHTML = xmlhttp3.responseText; //Update the HTML Form element
            spinIconOff();
            galleryBlurEffect();
        } else {
            alert("Error during AJAX call. Please try again");
        }
    }
}
//Upload Image
var xmlhttp4 = new getXMLObject(); //xmlhttp holds the ajax object
function ajaxUploadImage() {


    var getdate = new Date(); //Used to prevent caching during ajax call
    if (xmlhttp4) {
        var form = document.getElementById("uploadFormOrg");
        var photo = document.getElementById("photo");


        var nametag = document.getElementById('nametag').value;
        var type = document.getElementById('type').checked;
        // alert(type);
        var profile = document.getElementById('prof').checked;

        var fd = new FormData();
        fd.append("nametag", nametag);
        fd.append("type", type);
        fd.append("profile", profile);
        fd.append("photo", photo.files[0]);

        xmlhttp4.open("POST", "UploadImgServlet", true);
        xmlhttp4.onreadystatechange = handleServerResponseUpload;
        xmlhttp4.send(fd);

        spinIconOn();
    }


}

function handleServerResponseUpload() {
    if (xmlhttp4.readyState == 4) {
        if (xmlhttp4.status == 200) {




            var req = xmlhttp4.responseText;
            if (xmlhttp4.responseText == "") {
                document.getElementById("uploadMsg").innerHTML = "<p style=\"color:red; \">No image Selected</p>";
                spinIconOff();
            } else {
                $("#ib-container2").prepend(xmlhttp4.responseText);
                spinIconOff();
                document.getElementById("uploadMsg").innerHTML = "<p style=\"color:green; \">Successfuly Uploaded</p>";

            }
            galleryBlurEffect();
            // document.getElementById("uploadMsg").innerHTML = xmlhttp4.responseText;

            //document.getElementById("ib-container2").innerHTML = xmlhttp4.responseText+old_html;

        } else {
            alert("Error during AJAX call. Please try again");
        }
    }
}

//Search Image
var xmlhttp5 = new getXMLObject(); //xmlhttp holds the ajax object
function ajaxSearchImage() {


    var getdate = new Date(); //Used to prevent caching during ajax call
    if (xmlhttp5) {
        var tag = document.getElementById('nametagSearch').value;
        xmlhttp5.open("POST", "SearchImagesServlet?tag=" + tag, true); //gettime will be the servlet name
        xmlhttp5.onreadystatechange = handleServerResponseSearchImage;
        xmlhttp5.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xmlhttp5.send();
        spinIconOn()


    }


}

function handleServerResponseSearchImage() {
    if (xmlhttp5.readyState == 4) {
        if (xmlhttp5.status == 200) {
            document.getElementById("ib-container2").innerHTML = xmlhttp5.responseText; //Update the HTML Form element
            spinIconOff();
            galleryBlurEffect();

        } else {
            alert("Error during AJAX call. Please try again");
        }
    }
}



//Search Friends
var xmlhttp6 = new getXMLObject(); //xmlhttp holds the ajax object
function ajaxSearchFriend() {


    var getdate = new Date(); //Used to prevent caching during ajax call
    if (xmlhttp6) {
        var username = document.getElementById('friendsSearchInput').value;
        xmlhttp6.open("POST", "SearchFriendsServlet?username=" + username, true); //gettime will be the servlet name
        xmlhttp6.onreadystatechange = handleServerResponseSearchFriend;
        xmlhttp6.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xmlhttp6.send();
        spinIconOn()


    }


}

function handleServerResponseSearchFriend() {
    if (xmlhttp6.readyState == 4) {
        if (xmlhttp6.status == 200) {
            document.getElementById("ib-container2").innerHTML = xmlhttp6.responseText; //Update the HTML Form element
            spinIconOff();
            galleryBlurEffect();

        } else {
            alert("Error during AJAX call. Please try again");
        }
    }
}

//Send Friend Request Friends
var xmlhttp7 = new getXMLObject(); //xmlhttp holds the ajax object
function ajaxSendFriendRequest(sender, receiver) {


    var getdate = new Date(); //Used to prevent caching during ajax call
    if (xmlhttp7) {
        var username = document.getElementById('friendsSearchInput').value;
        xmlhttp7.open("POST", "SendFriendRequestServlet?sender=" + sender + "&receiver=" + receiver, true); //gettime will be the servlet name
        xmlhttp7.onreadystatechange = handleServerResponseSendFriendRequest;
        xmlhttp7.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xmlhttp7.send();
        spinIconOn();


    }


}

function handleServerResponseSendFriendRequest() {
    if (xmlhttp7.readyState == 4) {
        if (xmlhttp7.status == 200) {

            var resp = xmlhttp7.responseText;
            document.getElementById("dialog-3").innerHTML = resp;

            $("#dialog-3").dialog({
                autoOpen: false,
                hide: "puff",
                show: "slide",
                height: 200
            });
            $("#dialog-3").dialog("open");
            //document.getElementById("ib-container2").innerHTML = xmlhttp6.responseText; //Update the HTML Form element
            spinIconOff();
            //galleryBlurEffect();

        } else {
            alert("Error during AJAX call. Please try again");
        }
    }
}


//Check if the user is logged
var xmlhttp8 = new getXMLObject(); //xmlhttp holds the ajax object
function isLoggedAjax() {


    var getdate = new Date(); //Used to prevent caching during ajax call
    if (xmlhttp8) {
        xmlhttp8.open("POST", "Authenticator", true); //gettime will be the servlet name
        xmlhttp8.onreadystatechange = handleServerAuth;
        xmlhttp8.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xmlhttp8.send();
    }

}
function handleServerAuth() {
    if (xmlhttp8.readyState == 4) {
        if (xmlhttp8.status == 200) {
            var isLogged = xmlhttp8.responseText;

            if (isLogged.trim() === "True") {
                $("body").css({"display": "block"});
            } else {
                window.location = "login.html";

            }
        } else {
            alert("Error during AJAX call. Please try again");
        }
    }
}

//Register
var xmlhttp9 = new getXMLObject(); //xmlhttp holds the ajax object
function ajaxRegister() {


    var getdate = new Date(); //Used to prevent caching during ajax call
    if (xmlhttp9) {
        var username = document.getElementById('usr').value;
        var password = document.getElementById('pass').value;
        var repass = document.getElementById('repass').value;
        var name = document.getElementById('name').value;
        var email = document.getElementById('email').value;

        xmlhttp9.open("POST", "RegisterServlet?usr=" + username + "&pass=" + password + "&repass=" + repass + "&name=" + name + "&email=" + email, true); //gettime will be the servlet name
        xmlhttp9.onreadystatechange = handleRegisterRequest;
        xmlhttp9.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xmlhttp9.send();
        spinIconOn();
    }


}

function handleRegisterRequest() {
    if (xmlhttp9.readyState == 4) {
        if (xmlhttp9.status == 200) {
            spinIconOff();
            var resp = xmlhttp9.responseText;
            if (resp.trim() === "Success") {
                spinIconOn();
                document.getElementById("msg").style.color = "green";
                setTimeout(function () {
                    window.location = "login.html";
                    spinIconOff();
                }, 1500);
            } else {
                document.getElementById("msg").style.color = "red";
            }
            document.getElementById("msg").innerHTML = resp;


        } else {
            alert("Error during AJAX call. Please try again");
        }
    }
}


//Login
var xmlhttp10 = new getXMLObject(); //xmlhttp holds the ajax object
function ajaxLogIn() {


    var getdate = new Date(); //Used to prevent caching during ajax call
    if (xmlhttp10) {
        var username = document.getElementById('u').value;
        var password = document.getElementById('p').value;


        xmlhttp10.open("POST", "LoginServlet?u=" + username + "&p=" + password, true); //gettime will be the servlet name
        xmlhttp10.onreadystatechange = handleLoginRequest;
        xmlhttp10.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xmlhttp10.send();
        spinIconOn();
    }


}

function handleLoginRequest() {
    if (xmlhttp10.readyState == 4) {
        if (xmlhttp10.status == 200) {
            spinIconOff();
            var resp = xmlhttp10.responseText;
            if (resp.trim() === "Success") {
                spinIconOn();
                document.getElementById("msg").style.color = "green";
                setTimeout(function () {
                    window.location = "index.html";
                    spinIconOff();
                }, 1500);
            } else {
                document.getElementById("msg").style.color = "red";
            }
            document.getElementById("msg").innerHTML = resp;


        } else {
            alert("Error during AJAX call. Please try again");
        }
    }
}

//Show User Profile
var xmlhttp11 = new getXMLObject();
function ajaxShowProfile() {
    var getdate = new Date(); //Used to prevent caching during ajax call
    if (xmlhttp11) {


        var command = "show";
        xmlhttp11.open("POST", "ProfileOperationsServlet?command=" + command, true); //gettime will be the servlet name
        xmlhttp11.onreadystatechange = handleajaxShowProfile;
        xmlhttp11.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xmlhttp11.send();
    }
}
function handleajaxShowProfile() {
    if (xmlhttp11.readyState == 4) {
        if (xmlhttp11.status == 200) {
            var resp = xmlhttp11.responseText;

            document.getElementById("MyProfile").innerHTML = xmlhttp11.responseText; //Update the HTML Form element
        } else {
            alert("Error during AJAX call. Please try again");
        }
    }
}

//Show Requests
var xmlhttp12 = new getXMLObject();
function ajaxShowRequests() {
    var getdate = new Date(); //Used to prevent caching during ajax call
    if (xmlhttp12) {

        var command = "showRequests";
        xmlhttp12.open("POST", "ProfileOperationsServlet?command=" + command, true); //gettime will be the servlet name
        xmlhttp12.onreadystatechange = handleajaxShowRequest;
        xmlhttp12.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xmlhttp12.send();
        spinIconOn();
    }
}
function handleajaxShowRequest() {
    if (xmlhttp12.readyState == 4) {
        if (xmlhttp12.status == 200) {

            document.getElementById("ib-container2").innerHTML = xmlhttp12.responseText; //Update the HTML Form element
            spinIconOff();
            galleryBlurEffect();
        } else {
            alert("Error during AJAX call. Please try again");
        }
    }
}


//Confirm Friend Request
var xmlhttp13 = new getXMLObject();
function ajaxConfirmRequest(friend) {
    var getdate = new Date(); //Used to prevent caching during ajax call
    if (xmlhttp13) {

        var command = "confirmRequest";
        xmlhttp13.open("POST", "ProfileOperationsServlet?command=" + command + "&friend=" + friend, true); //gettime will be the servlet name
        xmlhttp13.onreadystatechange = handleajaxConfirmRequest;
        xmlhttp13.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xmlhttp13.send();
        spinIconOn();
    }
}
function handleajaxConfirmRequest() {
    if (xmlhttp13.readyState == 4) {
        if (xmlhttp13.status == 200) {

            spinIconOff();
            var resp = xmlhttp13.responseText;
            document.getElementById("dialog-3").innerHTML = resp;

            $("#dialog-3").dialog({
                autoOpen: false,
                hide: "puff",
                show: "slide",
                height: 200
            });
            $("#dialog-3").dialog("open");
            spinIconOn();
            setTimeout(function () {
                ajaxShowFriends();
                spinIconOff();
            }, 2000);
            ajaxShowFriends();
        } else {
            alert("Error during AJAX call. Please try again");
        }
    }
}


//Show Friends
var xmlhttp14 = new getXMLObject();
function ajaxShowFriends() {
    var getdate = new Date(); //Used to prevent caching during ajax call
    if (xmlhttp14) {

        var command = "showFriends";
        xmlhttp14.open("POST", "ProfileOperationsServlet?command=" + command, true); //gettime will be the servlet name
        xmlhttp14.onreadystatechange = handleajaxShowFriends;
        xmlhttp14.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xmlhttp14.send();
        spinIconOn();
    }
}
function handleajaxShowFriends() {
    if (xmlhttp14.readyState == 4) {
        if (xmlhttp14.status == 200) {

            document.getElementById("ib-container2").innerHTML = xmlhttp14.responseText; //Update the HTML Form element
            spinIconOff();
            galleryBlurEffect();

        } else {
            alert("Error during AJAX call. Please try again");
        }
    }
}

//Decline Request
var xmlhttp15 = new getXMLObject();
function ajaxDeclineRequest(friend) {
    var getdate = new Date(); //Used to prevent caching during ajax call
    if (xmlhttp15) {

        var command = "declineRequest";
        xmlhttp15.open("POST", "ProfileOperationsServlet?command=" + command + "&friend=" + friend, true); //gettime will be the servlet name
        xmlhttp15.onreadystatechange = handleajaxDeclineRequest;
        xmlhttp15.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xmlhttp15.send();
        spinIconOn();
    }
}
function handleajaxDeclineRequest() {
    if (xmlhttp15.readyState == 4) {
        if (xmlhttp15.status == 200) {

            var resp = xmlhttp15.responseText;
            if (resp.trim() != "Error") {
                document.getElementById("dialog-3").innerHTML = "<div style='color:green;'>You Declined The Friend Request.</div>";

                $("#dialog-3").dialog({
                    autoOpen: false,
                    hide: "puff",
                    show: "slide",
                    height: 200
                });
                $("#dialog-3").dialog("open")
            }
            document.getElementById("ib-container2").innerHTML = xmlhttp15.responseText; //Update the HTML Form element
            spinIconOff();
            galleryBlurEffect();

        } else {
            alert("Error during AJAX call. Please try again");
        }
    }
}

//Remove Friend 
var xmlhttp17 = new getXMLObject();
function ajaxRemoveFriend(friend) {

    var getdate = new Date(); //Used to prevent caching during ajax call
    if (xmlhttp17) {

        var command = "removeFriend";
        xmlhttp17.open("POST", "ProfileOperationsServlet?command=" + command + "&friend=" + friend, true); //gettime will be the servlet name
        xmlhttp17.onreadystatechange = handleajaxRemoveFriend;
        xmlhttp17.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xmlhttp17.send();
        spinIconOn();
    }
}
function handleajaxRemoveFriend() {
    if (xmlhttp17.readyState == 4) {
        if (xmlhttp17.status == 200) {
            var resp = xmlhttp17.responseText;
            if (resp.trim() != "Error") {
                document.getElementById("dialog-3").innerHTML = "<div style='color:green;'>The friend has been removed successfully.</div>";

                $("#dialog-3").dialog({
                    autoOpen: false,
                    hide: "puff",
                    show: "slide",
                    height: 200
                });
                $("#dialog-3").dialog("open")
            }
            document.getElementById("ib-container2").innerHTML = xmlhttp17.responseText; //Update the HTML Form element
            spinIconOff();
            galleryBlurEffect();

        } else {
            alert("Error during AJAX call. Please try again");
        }
    }
}

//Show conversation  
var xmlhttp18 = new getXMLObject();
var friendId = '';
var selectedUser = "";
function selectedUsera(friend) {
    selectedUser = friend;
}
window.setInterval(function () {
    if (selectedUser != "") {
        ajaxShowConversation();
    }
}, 1000);
function ajaxShowConversation( ) {

    var friend = selectedUser;
    friendId = friend;

    var getdate = new Date(); //Used to prevent caching during ajax call
    if (xmlhttp18) {

        var command = "showConversation";

        var msgInputId = "message" + friendId;
        var msg = "";


        xmlhttp18.open("POST", "ProfileOperationsServlet?command=" + command + "&friend=" + friend + "&msg=" + "", true); //gettime will be the servlet name
        xmlhttp18.onreadystatechange = handleajaxShowConversation;
        xmlhttp18.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xmlhttp18.send();

    }
}
function handleajaxShowConversation() {
    if (xmlhttp18.readyState == 4) {
        if (xmlhttp18.status == 200) {

            var msgInputId = "message" + friendId;
            document.getElementById(msgInputId).style.display = "block";

            var conversation = "conversation" + friendId;
            document.getElementById(conversation).innerHTML = xmlhttp18.responseText; //Update the HTML Form element



        } else {
            alert("Error during AJAX call. Please try again");
        }
    }
}
//send message
var xmlhttp19 = new getXMLObject();
function ajaxSendMessage() {

    var friend = selectedUser;
    friendId = friend;

    var getdate = new Date(); //Used to prevent caching during ajax call
    if (xmlhttp19) {

        var command = "showConversation";

        var msgInputId = "message" + friendId;
        var msg = "";
        if (document.getElementById(msgInputId) != null) {
            msg = document.getElementById(msgInputId).value;

        }

        xmlhttp19.open("POST", "ProfileOperationsServlet?command=" + command + "&friend=" + friend + "&msg=" + msg, true); //gettime will be the servlet name
        xmlhttp19.onreadystatechange = handleajaxSendMessage;
        xmlhttp19.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xmlhttp19.send();
        spinIconOn();
    }
}
function handleajaxSendMessage() {
    if (xmlhttp19.readyState == 4) {
        if (xmlhttp19.status == 200) {
            ajaxShowConversation();
            var msgInputId = "message" + friendId;
            document.getElementById(msgInputId).value = "";
            spinIconOff();


        } else {
            alert("Error during AJAX call. Please try again");
        }
    }
}


//AJAX========================================================================================================================================


function deleteImgConf(id) {
    ajaxDeleteComment(id);
    document.getElementById(id).style.display = "none";
}