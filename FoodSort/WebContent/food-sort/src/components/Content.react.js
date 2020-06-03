import {Component} from "react";
import React from "react";
import FoodStore from "../stores/FoodStore";

function getFoodData() {
    return FoodStore.getData();
}

class Content extends Component {
    constructor(props) {
        super(props);

        this.state = getFoodData();

        this.setState = this.setState.bind(this);
        this.onChange = this.onChange.bind(this);
    }

    componentDidMount() {
        FoodStore.addChangeListener(this.onChange);
    }

    componentWillUnmount() {
        FoodStore.removeChangeListener(this.onChange)
    }

    onChange() {
        this.setState(getFoodData());
    }

    render() {
        //just loop through the data and print out the food
        let foods = [];
        if(this.state.data != null) {
            this.state.data.forEach(function (food, index) {
                foods.push(<div id={index}>{food.whoAMI + ' ' + food.size}</div>)
            })
        }
        return (
            <div>
                <span>{this.state.message}</span>
                <div>
                    {foods}
                </div>
            </div>
        );
    }
}
export default Content