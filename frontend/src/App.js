 
import React from 'react';
import './App.css';
import Form from './Form' 
import { Typography } from '@mui/material';
function App() {
  return (
    <div className="App">
         <Typography className = "headingtext" variant="h2" gutterBottom>
       Yoga Classes Registration Form
      </Typography>
     <Form />   
    </div>
  )
}

export default App;
 