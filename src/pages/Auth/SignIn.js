import React, { useState } from 'react';
import { Button } from '@material-ui/core';
import { TextField, FormHelperText } from '@material-ui/core';
import Grid from '@material-ui/core/Grid';
import { fade, makeStyles } from '@material-ui/core/styles';
import axios from 'axios';
const useStyles = makeStyles((theme) => ({
  root: {
    '& > *': {
      paddingTop: '10px',
      width: '140ch',
      backgroundColor: fade(theme.palette.common.white),
      '&:hover': {
        backgroundColor: fade(theme.palette.common.white),
      },
    },
  },

  inputInput: {
    backgroundColor: 'white',
    borderRadius: '4px',
    fontWeight: 500,
  },
}));
const validEmailRegex = RegExp(
  /^(([^<>()[\].,;:\s@"]+(\.[^<>()[\].,;:\s@"]+)*)|(".+"))@(([^<>()[\].,;:\s@"]+\.)+[^<>()[\].,;:\s@"]{2,})$/i
);
const SignIn = () => {
  const [values, setValues] = useState({
    email: '',
    password: '',
  });
  const [errors, setErrors] = useState({
    emailErr: null,
    passwordErr: null,
  });

  const handleSubmit = (e) => {
    e.preventDefault();
    const data = { mail: values.email, login: '', password: values.password };
    if (email != '' && password != '' && errors.passwordErr == '' && errors.emailErr == '') {
      axios({
        method: 'post',
        url: '/api/auth',
        data: data, // you are sending body instead
        headers: {
          'Content-type': 'application/json; charset=UTF-8',
        },
      }).then(
        (response) => {
          console.log(response);
        },
        (error) => {
          console.log(error);
        }
      );
    }
  };
  const handleChange = (event) => {
    const { name, value } = event.target;
    switch (name) {
      case 'email':
        errors.emailErr = validEmailRegex.test(event.target.value) ? '' : 'Email is not valid!';
        break;
      case 'password':
        errors.passwordErr = value.length < 5 ? ' les 5 caractéres' : '';
        break;
    }
    setErrors(errors);
    setValues({ ...values, [name]: value });
  };
  const classes = useStyles();
  const { email, password } = values;
  const { emailErr, passwordErr } = errors;
  return (
    <form className={classes.root} onSubmit={handleSubmit} noValidate autoComplete='off'>
      <Grid container spacing={3} justify='flex-end'>
        <Grid item xs={2}>
          <TextField
            label='Email'
            value={email}
            name='email'
            size='small'
            onChange={handleChange}
            className={classes.inputInput}
          />
        </Grid>
        <Grid item xs={2}>
          <TextField
            className={classes.inputInput}
            label='Password'
            type='password'
            name='password'
            size='small'
            value={password}
            onChange={handleChange}
          />
        </Grid>

        <Grid item xs={3}>
          <div className='submit'>
            <Button variant='contained' onClick={handleSubmit} color='primary'>
              Login
            </Button>
            <br />
            <FormHelperText>
              {passwordErr}
              {emailErr}
            </FormHelperText>
          </div>
        </Grid>
      </Grid>
    </form>
  );
};
export default SignIn;
