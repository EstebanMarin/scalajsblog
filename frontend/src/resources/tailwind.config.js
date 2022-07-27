/** @type {import('tailwindcss').Config} */

const scalaversion = require('./scala-version')

module.exports = {
  content: [
    "./dist/index-dev.html",
    `./target/scala-${scalaversion}'/frontend-fastopt.js`
  ],
  theme: {
    extend: {},
  },
  plugins: [],
}
// https://tailwindcss.com/docs/installation
// https://daisyui.com/docs/config/