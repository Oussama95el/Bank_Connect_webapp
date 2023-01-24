module.exports = {
  content: [
    "./src/**/*.{html,ts}",
  ],
  theme: {
   extend: {
     backgroundColor:{
       "primary": "#e85311",
       "secondary": "#e1ddde",
       "danger": "#e3342f",
       "success": "#38c172",
     },
     fontFamily: {
       "sans": ["Arial", "sans-serif"],
       "serif": ["Arial", "serif"],
     },
     textColor: {
       "primary": "#e85311",
       "secondary": "#e1ddde",
       "default": "#000000",
     }
   },
  },
  plugins: [],
}
