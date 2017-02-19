package com.qin.isys.modules.base.web;

/**
 * Created by Q on 2017/2/19.
 */
public abstract class BaseController {

    protected class Result{
        private State state;
        private Object message;
        private Object postscript;
        public Result() {

        }

        public Result(State state) {
            this.state=state;
        }

        public Result(State state,Object message) {
            this.state=state;
            this.message=message;
        }

        public Result(State state,Object message,Object postscript) {
            this.state=state;
            this.message=message;
            this.postscript=postscript;
        }

        public State getState() {
            return state;
        }

        public void setState(State state) {
            this.state = state;
        }

        public Object getMessage() {
            return message;
        }

        public void setMessage(Object message) {
            this.message = message;
        }

        public Object getPostscript() {
            return postscript;
        }

        public void setPostscript(Object postscript) {
            this.postscript = postscript;
        }
    }

    protected enum State{
        OK("OOOOOOOOOOOOOOOOOk"),ERROR("ERRRRRRRRRROR");

        State(String state) {
            this.state = state;
        }

        private String state;
        @Override
        public String toString() {
            return state;
        }
    }
}
