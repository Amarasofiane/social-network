import React, { useState } from 'react';
import { Button } from '@material-ui/core';
import { TextField } from '@material-ui/core';
import Grid from '@material-ui/core/Grid';
import { makeStyles } from '@material-ui/core/styles';
const useStyles = makeStyles((theme) => ({
  inputInput: {
    backgroundColor: 'white',
    borderRadius: '4px',
  },
}));
const SignUp = () => {
  const classes = useStyles();

  const [error, setError] = useState('');
  const [values, setValues] = useState({
    fullName: '',
    username: '',
    email: '',
    password: '',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setValues({ ...values, [name]: value });
  };
  const handleSubmit = () => {
    console.log('AAA');
  };
  const { fullName, email, password, username } = values;

  return (
    <form onSubmit={handleSubmit} noValidate>
      <Grid container direction='row' justify='center' alignItems='center' spacing={3}>
        <Grid item>
          <h1>Create Account</h1>
        </Grid>
        <Grid item>
          <TextField
            size='small'
            label='Full name'
            type='fullName'
            value={fullName}
            onChange={handleChange}
            className={classes.inputInput}
          />
        </Grid>
        <Grid item>
          <TextField
            size='small'
            label='User Name'
            type='username'
            value={username}
            onChange={handleChange}
            className={classes.inputInput}
          />
        </Grid>
        <Grid item>
          <TextField
            size='small'
            label='Email'
            value={email}
            type='mail'
            onChange={handleChange}
            className={classes.inputInput}
          />
        </Grid>
        <Grid item>
          <TextField
            size='small'
            label='Password'
            type='password'
            value={password}
            onChange={handleChange}
            className={classes.inputInput}
          />
        </Grid>
        <Grid item xs={6}>
          <Button variant='contained' onClick={handleSubmit} color='primary'>
            Register
          </Button>
        </Grid>
      </Grid>
    </form>
  );
};
export default SignUp;
