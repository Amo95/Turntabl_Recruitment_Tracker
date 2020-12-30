import React from 'react';
import { Switch, Route } from 'react-router-dom'
import ForgotPassword from '../components/applicant/forgotPassword';
import Togle from '../components/applicant/Togle';
import LandingPage from '../components/portal/landingPage';
import DashBoard from '../components/portal/dashboard';
import PrivateRoute from './privateRoutes';

const PublicRoutes = (props) => {
    return (
        <Switch>
            <Route exact={true} path="/" component={LandingPage} />
            <Route exact={true} path="/togle" component={Togle} />
            <Route exact={true} path="/recover" component={ForgotPassword} />
            <PrivateRoute path="/apply" component={DashBoard} />
        </Switch>

    )
}

export default PublicRoutes;