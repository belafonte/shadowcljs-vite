import { defineConfig } from "vite";
import { fileURLToPath } from "node:url";
import react from "@vitejs/plugin-react";

export default defineConfig({
  plugins: [react()],
  server: {
    watch: {
      // Exclude .cljs files
      // so changes dont trigger multiple reloads
      ignored: "**/*.cljs",
    },
  },
  resolve: {
    alias: [
      {
        find: "@",
        replacement: fileURLToPath(new URL("./src/client", import.meta.url)),
      },
      {
        find: "@@",
        replacement: fileURLToPath(
          new URL("./src/client/components/ui", import.meta.url),
        ),
      },
    ],
  },
});
