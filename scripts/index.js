"use strict";

// Get elements: body, img button, img button when hovered, img container.
const body = document.querySelector("body");
const profileContainer = document.querySelector(".profileContainer");

// When profile image button is hovered upon and clicked, background changes to pitch black and 2 new buttons replace the profile image button, with each button navigates to its corresponding page when clicked.

// body fades out first, then invoke callback function to bring back body.
$(document).ready(() => {
  const $profileBtn = $("img");
  $profileBtn.on("click", () => {
    $("body").fadeOut(1000);
    setTimeout(() => {
      $("body").fadeIn(750);
      switchToBtnView();
    }, 1005);
  });
});

/**
 * Set background to black and display to block.
 * @param {*} body
 */
const bringBackDarkBg = (body) => {
  body.style.background = "#000000";
  body.style.display = "block";
};

/**
 * Hide the profile photo button
 */
const hideProfilePhoto = () => {
  document.querySelector("img").style.display = "none";
  document.querySelector(".bgContainer").style.display = "none";
};

/**
 * Create the button container div
 * Don't use innerHTML to prevent XSS and HTML injection.
 * @returns btnContainerDiv
 */
const createBtnContainer = () => {
  const btnContainerDiv = document.createElement("div");
  btnContainerDiv.className = "btnContainer";
  return btnContainerDiv;
};

/**
 * Create the "SW Engineer" button and link to page.
 * @returns the link to the "SW Engineer" button.
 */
const createSWBtnAndLink = () => {
  const swLink = document.createElement("a");
  swLink.href = "sw.html";
  swLink.target = "_blank";
  const swBtn = document.createElement("button");
  swBtn.className = "button swBtn";
  swBtn.textContent = "SW Engineer";
  swLink.appendChild(swBtn); // Add the button to the link
  return swLink;
};

/**
 * Create the "AppSec Engineer" button and link to page.
 * @returns the link to the "AppSec Engineer" button.
 */
const createAppSecBtnAndLink = () => {
  const appSecLink = document.createElement("a");
  appSecLink.href = "as.html";
  const appSecBtn = document.createElement("button");
  appSecBtn.className = "button appSecBtn";
  appSecBtn.textContent = "AppSec Engineer";
  appSecLink.appendChild(appSecBtn);
  return appSecLink;
};

/**
 * Create dynamic background and the two buttons required to navigate to other pages.
 */
const switchToBtnView = () => {
  bringBackDarkBg(body);
  hideProfilePhoto();
  const btnContainerDiv = createBtnContainer();
  const swLink = createSWBtnAndLink();
  const appSecLink = createAppSecBtnAndLink();
  // Add both links to the container
  btnContainerDiv.appendChild(swLink);
  btnContainerDiv.appendChild(appSecLink);
  // Finally, append the container to the profileContainer
  profileContainer.appendChild(btnContainerDiv);
};