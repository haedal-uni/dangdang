$(document).ready(function () {
    getmain();
})

function getmain() {
    $.ajax({
        type: "GET",
        url: `/mainpage`,
        data: {},
        success: function (response) {
            for (let i = 0; i < response.length; i++) {
                let idx = response[i]['idx'];
                let content = response[i]['content'];
                let image = response[i]['image'];
                let nickname = response[i]['nickname'];
                let userImg = response[i]['profileImgUrl'] ;
                makeListPost(idx, content, image, nickname, userImg);
            }
        }
    });
}

function makeListPost(idx, content, image, nickname, userImg) {
    let tempHtml = `<article class="contents cont">
                    <div class="img_section">
                        <div class="trans_inner">
                            <div class="content_image" id="content_image${idx}">
                                <img src="${image}" width="300" height="200" >
                            </div>
                        </div>
                    </div>
                    <div class="detail--right_box">
                        <header class="top">
                            <div class="user_container">
                                <div class="profile_img">
                                    <img src="${userImg}" alt="">
                                </div>
                                <div class="user_name">
                                    <div class="nick_name" id="NickName${idx}">${nickname}</div>
                                    <div class="address">address</div>
                                </div>
                            </div>
                            <div class="sprite_more_icon" data-name="more" data-toggle="modal" data-target="#exampleModal">
                            </div>
                        </header>
                        <section class="scroll_section">
                            <div class="user_container-detail">
                                <div class="comment" id="comment${idx}">
                                    <p>${content}</p>
                                </div>
                            </div>
                        </section>
                    </div>
                </article>`;
    $("#contents_box").append(tempHtml);
}






