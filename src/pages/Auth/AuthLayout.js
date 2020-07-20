import React from 'react';
import AuthHeader from './AuthHeader';
import SignUp from './SignUp';
import Grid from '@material-ui/core/Grid';
import './Styles.scss';
const AuthLayout = () => {
  return (
    <div class='roots'>
      <AuthHeader></AuthHeader>
      <div class='pageContent'>
        <div class='signUp'>
          <div class='cards'>
            <SignUp></SignUp>
          </div>
        </div>
      </div>
    </div>
  );
};
export default AuthLayout;
