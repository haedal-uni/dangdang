// $(document).ready(function () {
//     // getContents();
//     test();
// });
//
// function test() {
//     let test = sessionStorage.getItem("image_idx");
//     $.ajax({
//         type: "GET",
//         url: `/test?idx=${test}`,
//         data: {},
//         success: function (response) {
//             let tt = response['image'];
//             let temp_html = `<img src="${tt}">`;
//             $('#abc').append(temp_html);
//         }
//     });
// }


function test2() {
    $.ajax({
        type: "GET",
        url: `/test2`,
        data: {},
        success: function (response) {
            for (let i = 0; i < response.length; i++) {
                let idx = response[i]['idx'];
                let content = response[i]['content'];
                let image = response[i]['image'];
                let date = response[i]['createdAt'];
                makeListPost(idx, content, image);
            }
        }
    });
}
function makeListPost(idx, content, image) {
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
                                    <img src=images/thumb02.jpg alt="">
                                </div>
                                <div class="user_name">
                                    <div class="nick_name" id="NickName${idx}">Nickname</div>
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




$(document).ready(function () {
    test2();
})



// function getContents() {
//     $.ajax({
//         type: "GET",
//         url: "/api/upload",
//         contentType: 'application/json; charset=utf-8',
//         success: function (response) {
//             for (let i = 0; i < response.length; i++){
//                 makeListPost(response[i], i);
//             }
//         }
//     })
// }

// function makeListPost(article, index) {
//     let tempHtml = `<article class="contents cont">
//                     <div class="img_section">
//                         <div class="trans_inner">
//                             <div class="content_image" id="content_image${index}">
//                                 <img src=${article['image']} alt="">
//                             </div>
//                         </div>
//                     </div>
//                     <div class="detail--right_box">
//                         <header class="top">
//                             <div class="user_container">
//                                 <div class="profile_img">
//                                     <img src=images/thumb02.jpg alt="">
//                                 </div>
//                                 <div class="user_name">
//                                     <div class="nick_name" id="NickName${index}">Nickname</div>
//                                     <div class="address">address</div>
//                                 </div>
//                             </div>
//                             <div class="sprite_more_icon" data-name="more" data-toggle="modal" data-target="#exampleModal">
//                             </div>
//                         </header>
//                         <section class="scroll_section">
//                             <div class="user_container-detail">
//                                 <div class="comment" id="comment${index}">
//                                     <p>${article['content']}</p>
//                                 </div>
//                             </div>
//                         </section>
//                     </div>
//                 </article>`;
//     $("#contents_box").append(tempHtml);
// }