# Bootstrap Sass Customization

Steps:

1. Install Node.js

2. Create Project

npm init -y

3. Install Bootstrap

npm install bootstrap

4. Install Sass

npm install sass

5. Create custom.scss

$primary: #ff6600;

$border-radius: 1rem;

@import "bootstrap/scss/bootstrap";

6. Compile

sass custom.scss custom.css

Result:
Bootstrap is rebuilt using custom colors and border radius.