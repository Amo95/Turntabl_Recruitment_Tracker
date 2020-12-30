import React, { Component } from 'react';
import { connect } from 'react-redux'

class Tracker extends Component {
    state = {  }
    render() { 
        return ( <div className="tracker-body">
            this is tracker
        </div> );
    }
}
 
export default connect() (Tracker);