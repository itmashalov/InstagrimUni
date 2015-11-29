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
                window.location = "login.jsp";

            }
        } else {
            alert("Error during AJAX call. Please try again");
        }
    }
}

//AJAX========================================================================================================================================


function deleteImgConf(id) {

    //  if (confirm("Are you Sure that you want to delete this image?") == true) {
    ajaxDeleteComment(id);
    document.getElementById(id).style.display = "none";
    //call ajax
    //} else {

    //}


}