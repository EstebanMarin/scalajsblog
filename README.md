# Blog
I decided I wanted to start bloging. But who needs complicated tools when you can make software yourself.
# front-end
- [tailwind](https://tailwindcss.com/docs/installation)
- [daisyui](https://daisyui.com/docs/install/)
- [Tailwind cheatsheet](https://nerdcave.com/tailwind-cheat-sheet)
## Prepare the client
1. At first, run `yarn install` within `frontend/src`.
2. Build the tailwind based CSS with `npx tailwindcss -i ./src/input.css -o ./dist/output.css --watch` or `npm run tail`
3. to have a clean development experience, you will have to run `npm run tail` and `sbt frontend/fastlink` in parallel so your utility clases are created.