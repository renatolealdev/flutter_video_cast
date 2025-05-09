package it.aesys.flutter_video_cast

import androidx.annotation.NonNull
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.activity.ActivityAware
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding

/** FlutterVideoCastPlugin */
public class FlutterVideoCastPlugin: FlutterPlugin, ActivityAware {
  private lateinit var chromeCastFactory: ChromeCastFactory

  override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    chromeCastFactory = ChromeCastFactory(flutterPluginBinding.binaryMessenger)
    flutterPluginBinding
            .platformViewRegistry
            .registerViewFactory(
                    "ChromeCastButton",
                    chromeCastFactory
            )
  }

  override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
    // Nada a fazer aqui
  }

  override fun onAttachedToActivity(binding: ActivityPluginBinding) {
    chromeCastFactory.activity = binding.activity
  }

  override fun onDetachedFromActivityForConfigChanges() {
    // Nada a fazer aqui
  }

  override fun onDetachedFromActivity() {
    // Nada a fazer aqui
  }

  override fun onReattachedToActivityForConfigChanges(binding: ActivityPluginBinding) {
    chromeCastFactory.activity = binding.activity
  }
}
