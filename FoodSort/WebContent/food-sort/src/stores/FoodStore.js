import AppDispatcher from '../dispatcher/AppDispatcher';
import EventEmitter from 'events';
import assign from 'object-assign';

var CHANGE_EVENT = 'change';
var data = {
    message:'',
    data:[]
};

let FoodStore = assign({}, EventEmitter.prototype, {

    emitChange: function () {
        this.emit(CHANGE_EVENT);
    },
    addChangeListener: function(callback) {
        this.on(CHANGE_EVENT, callback);
    },

    removeChangeListener: function(callback) {
        this.removeListener(CHANGE_EVENT, callback);
    },

    loadData: function(result) {
        data.data = result.data.data;
        data.message = result.data.message;
    },

    getData() {
        return data;
    }
});

FoodStore.dispatchToken = AppDispatcher.register(function(result) {
    FoodStore.loadData(result);
    FoodStore.emitChange();

});

export default FoodStore