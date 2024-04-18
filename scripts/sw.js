"use strict";

const title = document.querySelector("span");

$(document).ready(() => {
  $("body").on("dblclick", () => {
    $("span.title").animate(
      {
        left: "2000px",
      },
      2000
    );
    $("p").animate(
      {
        right: "2000px",
      },
      2000
    );
    $(".btns").animate(
      {
        bottom: "1000px",
        left: "500px",
      },
      1000
    );
    $("body").fadeOut(4500);
    
    setTimeout(() => {
      window.close();
    }, 2000);
  });

  $("#gitHub").on("click", () => {
    window.open("https://github.com/ycx-8", "_blank");
  });

  $("span.title")
    .on("click", () => {
      window.open("https://linkedin.com/in/chenxi-yang8", "_blank");
    })
    .on("mousedown", () => {
      title.style.borderRadius = "20px";
      title.style.padding = "5px";
      title.style.background =
        "linear-gradient(to bottom, rgba(0, 0, 255, 1) 0%, rgba(0, 128, 0, 1) 100%)";
    })
    .hover(
      () => {
        title.style.borderRadius = "20px";
        title.style.padding = "5px";
        title.style.background =
          "linear-gradient(to top, rgba(0, 0, 255, 1) 0%, rgba(0, 128, 0, 1) 100%)";
        title.style.cursor = "pointer";
        $("span.title").text("Click to see LinkedIn ");
      },
      () => {
        $("span.title").text("Hi, I am Chenxi");
        title.style.padding = "0px";
        title.style.background = "transparent";
        title.style.cursor = "pointer";
      }
    );
});
