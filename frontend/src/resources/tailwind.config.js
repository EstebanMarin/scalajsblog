/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./**/*.{html}"],
  theme: {
    extend: {},
  },
  plugins: [require("@tailwindcss/typography"), require("daisyui")],
  daisyui: {
    styled: true,
    themes: true,
    base: true,
    utils: true,
    logs: true,
    rtl: false,
    prefix: "",
    darkTheme: "dark",
  },
}
// https://tailwindcss.com/docs/installation
// https://daisyui.com/docs/config/