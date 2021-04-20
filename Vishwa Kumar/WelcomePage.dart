import 'package:flutter/material.dart';

import 'MyApp.dart';

class WelcomePage extends StatelessWidget {
  void selectCategory(BuildContext ctx) {
    Navigator.of(ctx).push(
      MaterialPageRoute(
        builder: (_) {
          return MyApp();
        },
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Optimal Character Recognizer"),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () => selectCategory(context),
        child: Icon(Icons.arrow_forward_outlined),
      ),
      body: Container(
        child: Center(
          child: Text("Head to Image Upload and Preview Page"),
        ),
      ),
    );
  }
}
