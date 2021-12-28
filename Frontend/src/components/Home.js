import React, { Component } from "react";
import train from "../../src/resources/train.jpg";
import { BrowserRouter as Router, Switch , Link, Route,} from "react-router-dom";



export default class Home extends Component {
  render() {
    return (
      
       <div  style={{ 
        backgroundImage: `url(${train})`,
        backgroundPosition: 'center',
        backgroundSize: 'cover',
        backgroundRepeat: 'no-repeat',
        width: '98.5vw',
        height: '90vh'
      }}>
          <h1 style={{color:'white',textAlign:'center',paddingTop:200,paddingBottom:20}}>Welcome To Online Railway Reservation System</h1>
          <Link to="/SignUp">
                    <button type="button" style={{borderRadius:10,backgroundColor: 'white',marginLeft:650,padding:10}}>
                        Login/SignUp
                    </button>
            </Link>

      </div> 

 
      
    );
  }
}
