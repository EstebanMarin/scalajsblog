# Blog
I decided I wanted to start bloging. But who needs complicated tools when you can make software yourself.
# front-end
- [tailwind](https://tailwindcss.com/docs/installation)
- [daisyui](https://daisyui.com/docs/install/)
- [Tailwind cheatsheet](https://nerdcave.com/tailwind-cheat-sheet)
## Prepare the client
1. At first, run `yarn install` within `frontend/src`.
2. Build the tailwind based CSS with `npx tailwindcss -i ./src/input.css -o ./dist/output.css`
### Run the client
1. In another shell start a continuous compile of the Scala JS client code by starting a `sbt shell` and execute `~clientJS/fastOptJS`. This will recompile the Scala JS code upon each save of a related source file
2. In yet another shell, from within `frontend/` start `npx vite build -m development --watch`. This will repackage the web application upon on each change.
3. In yet another shell, from within `frontend` start `npx vite`. This will start a local HTTP server on port 3000 picking up the currently packaged application. http://localhost:3000 will now display the client.

In case you want to use a browser on a different machine than the machine where you have started the vite server, you have to start the vite server with npx vite --host 0.0.0.0, so that the vite server starts to listen on all network interfaces.