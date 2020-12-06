import React from "react";
import "./App.scss";
import { Login, Register } from "./components/applicant/index";
import { BrowserRouter as Router, Route, Switch, Link, Redirect } from "react-router-dom";
import Togle from "./components/applicant/Togle";

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      isLogginActive: true
    };
  }


  render() {
   
    return(
      <Router>
        
      {/* <Togle /> */}
      <Route path="/" component={Togle} exact={true}/>
      </ Router>
    )
    
  }
}

export default App;
