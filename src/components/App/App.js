import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import AuthLayout from '../../pages/Auth/AuthLayout';
import SignUp from '../../pages/Auth/SignUp';
const App = () => {
  return (
    <Router>
      <Switch>
        <Route exact render={() => <AuthLayout />}></Route>
      </Switch>
    </Router>
  );
};
export default App;
