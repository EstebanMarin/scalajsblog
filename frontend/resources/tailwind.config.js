/** @type {import('tailwindcss').Config} */

const scalaversion = require('./scala-version')

module.exports = {
  content: [
    "./dist/index-dev.html",
    "../target/scala-3.1.3/frontend-fastopt/main.js"
  ],
  theme: {
    extend: {},
  },
  plugins: [
    require('@tailwindcss/aspect-ratio'),
    require("@tailwindcss/typography"), 
    require("daisyui")],
  daisyui: {
    styled: true,
    themes: ["light", "dark", "corporate", "forest", "wireframe", "black", "luxury", "dracula", "business", "acid", "lemonade", "night", "coffee", "winter"],
    base: true,
    utils: true,
    logs: true,
    rtl: false,
    prefix: "",
    darkTheme: "dark",
  }
}
// https://tailwindcss.com/docs/installation
// https://daisyui.com/docs/config/