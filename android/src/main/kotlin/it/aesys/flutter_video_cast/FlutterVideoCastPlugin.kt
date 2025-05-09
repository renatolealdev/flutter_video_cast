package it.aesys.flutter_video_cast

import androidx.annotation.NonNull;

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.activity.ActivityAware
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
import io.flutter.plugin.common.PluginRegistry

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

  // Este método estático é opcional e equivalente ao onAttachedToEngine.
  // É mantido apenas para compatibilidade com projetos antigos do Flutter (pré-1.12)
  companion object {
    @JvmStatic
    fun registerWith(registrar: PluginRegistry.Registrar) {
      registrar
              .platformViewRegistry()
              .registerViewFactory(
                      "ChromeCastButton",
                      ChromeCastFactory(registrar.messenger())
              )
    }
  }

  override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
    
  }

  override fun onAttachedToActivity(binding: ActivityPluginBinding) {
    chromeCastFactory.activity = binding.activity
  }

  override fun onDetachedFromActivityForConfigChanges() {

  }

  override fun onDetachedFromActivity() {

  }

  override fun onReattachedToActivityForConfigChanges(binding: ActivityPluginBinding) {

  }
}
