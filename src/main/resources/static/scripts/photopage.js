$(document).ready(function () {
    getphoto();
})

function getphoto(){
    $.ajax({
        type: "GET",
        url: `/photos`,
        data: {},
        success: function (response) {
            for (let i = 0; i < response.length; i++) {
                let idx = response[i]['idx'];
                let image = response[i]['image'];
                makeListPhoto(idx, image);
            }
        }
    });
}
function makeListPhoto(idx,image) {
    let tempHtml = `<div class="dog_img" id="img_${idx}"><img src="${image}" alt=""></div>`
    $("#imgs_box").append(tempHtml);
}