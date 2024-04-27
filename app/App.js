import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View,Button} from 'react-native';
import React, {useEffect, useState} from 'react';
import {NavigationContainer} from '@react-navigation/native';
import {createNativeStackNavigator} from '@react-navigation/native-stack';
import { store } from './data/store'
import { Provider } from 'react-redux'
import { useSelector, useDispatch } from 'react-redux'
import { decrement, increment } from './data/slices/counter'


const Stack = createNativeStackNavigator();

export default function App() {



  return (
    <Provider store={store}>
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Home" component={HomeScreen} options={{title: 'Welcome'}}/>
        <Stack.Screen name="Profile" component={ProfileScreen} />
      </Stack.Navigator>
    </NavigationContainer>
    </Provider>
  );
};
  
const HomeScreen = ({navigation}) => {
  return (
    <View style={styles.container}>
      {/* <Text>Home Screen</Text> */}
 
    <Button  title="Iniciar" onPress={() =>navigation.navigate('Profile', {name: 'Jane'})}/>
      </View>
  );
};
const ProfileScreen = () => {

  const count = useSelector((state) => state.counter.value)
  const dispatch = useDispatch()
  const [counts, setCounts] = useState("0")
  useEffect(() => {
      setCounts(count)
  }), [count]
  return (
  <View style={styles.container}>
    <Text>Profile Screen</Text>
    <Text>count: {counts}</Text>
    <Button title="increnment" onPress={() => dispatch(increment())} />
{/* 
    <Button title="decrement" onPress={() => dispatch(decrement())} /> */}

  </View>
  )
};
const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
