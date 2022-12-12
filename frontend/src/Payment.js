import React from 'react'
import { Button } from '@mui/material'
import './App.css'


export const Payment = () => {
  return (<div 
  className="paymentWrapper">
    <Button variant="contained">Payment</Button>
    <Button variant="contained">Fail Payment</Button>
    </div>
  )
}
