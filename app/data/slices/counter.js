import { createSlice } from '@reduxjs/toolkit'

const initialState = {
  value: '0',
}

export const counterSlice = createSlice({
  name: 'counter',
  initialState,
  reducers: {
    increment: (state) => {
    let str = parseInt(state.value);
    let num= str += 1;
    state.value = num.toString();                                                                                                                                                                                                                                                                                       
    },
    decrement: (state) => {
    let str = parseInt(state.value);
    let num= str -= 1;
    state.value = num.toString();      

    },
    incrementByAmount: (state, action) => {
      state.value += action.payload
    },
  },
})

// Action creators are generated for each case reducer function
export const { increment, decrement, incrementByAmount } = counterSlice.actions

export default counterSlice.reducer