import * as React from "react";
import Grid from "@mui/material/Grid";
import TextField from "@mui/material/TextField";
import { InputLabel, Select, Button } from "@mui/material/";
import { MenuItem, FormControl } from "@mui/material";
import axios from "axios";

export default function Form() {
  const handle = async () => {
    setLoaded(true);
    await axios
      .post("http://localhost:8081/verify", {
        name: name,
        age: age,
        month: month,
        year: year,
        classId: slot,
      })
      .then((response) => {
        setApiCall(1+apiCall);
        setMessage(response.data.message);
        setVal(response.data.success);
      })
      .catch((error) => {
        console.log(error);
      });
  };
  const [name, setName] = React.useState("");
  const [age, setAge] = React.useState(0);
  const [month, setMonth] = React.useState(0);
  const [year, setYear] = React.useState(0);
  const [slot, setSlot] = React.useState(0);
  const [val, setVal] = React.useState();
  const [message, setMessage] = React.useState("");
  const [apiCall, setApiCall] = React.useState(0);
  const [loaded, setLoaded] = React.useState(false);

  React.useEffect(() => {
    if (loaded) alert(message);
  }, [apiCall]);

 
  const handlePaymentSuccess = async ()=>{
     
      await axios
      .post("http://localhost:8081/booking", {
        name: name,
        age: age,
        month: month,
        year: year,
        classId: slot,
        transaction:true
      })
      .then((response) => {
        setMessage(response.data.message);
  
        setApiCall(1+apiCall);
      })
      .catch((error) => {
        console.log(error);
      });
    } 
    const handlePaymentFailure = async ()=>{ 
      await axios
      .post("http://localhost:8081/booking", {
        name: name,
        age: age,
        month: month,
        year: year,
        classId: slot,
        transaction:false
      })
      .then((response) => {
        setMessage(response.data.message);
  
        setApiCall(1+apiCall);
      })
      .catch((error) => {
        console.log(error);
      });
    } 
  

  return (
    <>
      <form className="createForm">
        <Grid
          className="NewCustomerForm"
          container
          spacing={4}
          maxWidth="sm"
          margin="auto"
        >
          <Grid item xs={12}>
            <TextField
              required
              id="firstName"
              name="firstName"
              label="Name"
              fullWidth
              variant="standard"
              onChange={(e) => setName(e.target.value)}
            />
          </Grid>
          <Grid item xs={12}>
            <TextField
              required
              id="age"
              type="number"
              name="age"
              label="Age"
              fullWidth
              autoComplete="family-name"
              variant="standard"
              onChange={(e) => setAge(e.target.value)}
            />
          </Grid>
          <Grid item xs={12} sm={3}>
            <FormControl>
              {" "}
              <InputLabel>Month</InputLabel>
              <Select
                labelId="demo-simple-select-label"
                id="demo-simple-select"
                label="Month"
                onChange={(e) => setMonth(e.target.value)}
                sx={{ minWidth: 120 }}
              >
                <MenuItem value={1}>1</MenuItem>
                <MenuItem value={2}>2</MenuItem>
                <MenuItem value={3}>3</MenuItem>
                <MenuItem value={4}>4</MenuItem>
                <MenuItem value={5}>5</MenuItem>
                <MenuItem value={6}>6</MenuItem>
                <MenuItem value={7}>7</MenuItem>
                <MenuItem value={8}>8</MenuItem>
                <MenuItem value={9}>9</MenuItem>
                <MenuItem value={10}>10</MenuItem>
                <MenuItem value={11}>11</MenuItem>
                <MenuItem value={12}>12</MenuItem>
              </Select>
            </FormControl>
          </Grid>
          <Grid item xs={12} sm={3}>
            <FormControl>
              {" "}
              <InputLabel>Year</InputLabel>
              <Select
                labelId="demo-simple-select-label"
                id="demo-simple-select"
                // value={1}
                label="Month"
                sx={{ minWidth: 120 }}
                onChange={(e) => setYear(e.target.value)}
              >
                <MenuItem value={2022}>2022</MenuItem>
                <MenuItem value={2023}>2023</MenuItem>
                <MenuItem value={2024}>2024</MenuItem>
              </Select>
            </FormControl>
          </Grid>
          <Grid item xs={12} sm={6}>
            <FormControl>
              <InputLabel>Time Slot</InputLabel>
              <Select
                labelId="demo-simple-select-label"
                id="demo-simple-select"
                label="Age"
                onChange={(e) => setSlot(e.target.value)}
                sx={{ minWidth: 150 }}
              >
                <MenuItem value={1}>6-7AM</MenuItem>
                <MenuItem value={2}>7-8AM</MenuItem>
                <MenuItem value={3}>8-9AM</MenuItem>
                <MenuItem value={3}>5-6PM</MenuItem>
              </Select>
            </FormControl>
          </Grid>
          <Grid item>
            <Button variant="contained" type="button" onClick={handle}>
              Submit
            </Button>
          </Grid>
        </Grid>
        {val === true && (
        <div className="paymentWrapper">
          <Button variant="contained" type = "button" onClick={() => { handlePaymentSuccess()}} >
            Payment
          </Button>
          <Button variant="contained" type="button" onClick={() => { handlePaymentFailure()}} >
            Fail Payment
          </Button>
        </div>
      )}
      </form>
      
    </>
  );
}
