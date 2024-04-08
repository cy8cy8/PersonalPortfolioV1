"use strict";

// Get the required components
const bgVideo = document.querySelector(".bgContainer");
const body = document.querySelector("body");
const pitch = document.querySelector(".pitch");

const navigateToGitHub = () => {
  window.open("https://github.com/ycx-8/", "_blank");
};

const changeBg = () => {
  body.style.background = "#000";
  pitch.style.color = "#fff";
};

const restoreBg = () => {
  body.style.background = "#fff";
  pitch.style.color = "#000";
};