"use strict";

// Get elements: body, img button, img button when hovered, img container.
const body = document.querySelector("body");
const profileContainer = document.querySelector(".profileContainer");
const profileBtn = document.querySelector("img");
const profileBtnHover = document.querySelector("img:hover");

// When profile image button is hovered upon and clicked, background changes to pitch black and 2 new buttons replace the profile image button, with each button navigates to its corresponding page when clicked.
profileBtn.addEventListener("click", (e) => {
  e.preventDefault();
  body.style.background = "#000000";

  // Hide the profile photo.
  document.querySelector("img").style.display = "none";
  document.querySelector(".bgContainer").style.display = "none";

  // Don't use innerHTML to prevent XSS and HTML injection.
  // Create the container div.
  const btnContainerDiv = document.createElement("div");
  btnContainerDiv.className = "btnContainer";

  // Create the "SW Engineer" button and link to page.
  const swLink = document.createElement("a");
  swLink.href = "sw.html";
  swLink.target = "_blank";
  const swBtn = document.createElement("button");
  swBtn.className = "button swBtn";
  swBtn.textContent = "SW Engineer";
  swLink.appendChild(swBtn); // Add the button to the link

  // Create the "AppSec Engineer" button and link to page.
  const appSecLink = document.createElement("a");
  appSecLink.href = "as.html";
  const appSecBtn = document.createElement("button");
  appSecBtn.className = "button appSecBtn";
  appSecBtn.textContent = "AppSec Engineer";
  appSecLink.appendChild(appSecBtn); // Add the button to the link

  // Add both links to the container
  btnContainerDiv.appendChild(swLink);
  btnContainerDiv.appendChild(appSecLink);

  // Finally, append the container to the profileContainer
  profileContainer.appendChild(btnContainerDiv);
});
