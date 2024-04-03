import { defineConfig } from 'vite'
import { fileURLToPath } from 'node:url'

export default defineConfig({
  plugins: [],
  resolve: {
    alias: [
      {
        find: '@',
        replacement: fileURLToPath(new URL('./src', import.meta.url))
      },
      {
        find: '@@',
        replacement: fileURLToPath(new URL('./src/components/ui', import.meta.url))
      },
    ]
  }
});
