package me.nazarxexe.ui.testing

import me.nazarxexe.ui.Scheduler
import org.bukkit.command.CommandExecutor
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitTask

class XeXeGuiPlugin : JavaPlugin() {

    fun register(cmd: String, executor: CommandExecutor) {
        val o = getCommand(cmd) ?: error("Command $cmd not found check the plugin.yml.")
        o.setExecutor(executor)
    }

    override fun onEnable() {
        server.pluginManager.registerEvents(GuiHandle, this)
        val shedul = object : Scheduler {
            override fun run(runnable: () -> Unit): BukkitTask {
                return server.scheduler.runTask(this@XeXeGuiPlugin, runnable)
            }

            override fun runRepeat(repeat: Int, runnable: () -> Unit): BukkitTask {
                return server.scheduler.runTaskTimer(this@XeXeGuiPlugin, runnable, 0, repeat.toLong())
            }
        }
        register("xexegui_test_shimmer", ShimmerGuiCommand(shedul))
        register("xexegui_test_basic", BasicGuiCommand())
        register("xexegui_test_progressbar", ProgressBarGuiCommand(shedul))
        register("xexegui_test_route", RouteCommandTest(GuiHandle))
        register("xexegui_test_pagination", PaginationTestCommand())
    }
}